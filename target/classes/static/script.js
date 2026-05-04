const API_URL = "http://localhost:8080/todos";

let allTodos = [];

window.onload = () => fetchTodos();

// fetch all todos
function fetchTodos() {
    fetch(API_URL)
        .then(res => res.json())
        .then(data => {
            allTodos = data;

            // sort by priority (HIGH → LOW)
            const order = { HIGH: 3, MEDIUM: 2, LOW: 1 };
            data.sort((a, b) => order[b.priority] - order[a.priority]);

            renderTodos(data);
        });
}

// render todos
function renderTodos(todos) {
    const list = document.getElementById("todoList");
    list.innerHTML = "";

    if (todos.length === 0) {
        list.innerHTML = `<p class="text-center text-muted">No tasks available</p>`;
        return;
    }

    todos.forEach(todo => {
        const li = document.createElement("li");
        li.className = "list-group-item todo-item d-flex justify-content-between align-items-center";

        li.innerHTML = `
            <div>
                <h6 class="mb-1 ${todo.completed ? 'text-decoration-line-through text-muted' : ''}">
                    ${todo.title}
                </h6>

                <small class="text-muted">${todo.description || ""}</small><br>

                <span class="badge ${todo.completed ? 'bg-success' : 'bg-warning text-dark'}">
                    ${todo.completed ? 'Completed' : 'Pending'}
                </span>

                <span class="badge ${getPriorityClass(todo.priority)} ms-2">
                    ${todo.priority || "LOW"}
                </span>
            </div>

            <div class="d-flex gap-2">
                <button class="btn btn-sm btn-outline-success"
                    onclick="toggleComplete(${todo.id})">
                    ✓
                </button>

                <button class="btn btn-sm btn-outline-danger"
                    onclick="deleteTodo(${todo.id})">
                    ✕
                </button>
            </div>
        `;

        list.appendChild(li);
    });
}

// priority badge color
function getPriorityClass(priority) {
    if (priority === "HIGH") return "bg-danger";
    if (priority === "MEDIUM") return "bg-warning text-dark";
    return "bg-secondary";
}

// add todo
function addTodo() {
    const title = document.getElementById("title").value.trim();
    const description = document.getElementById("desc").value.trim();
    const completed = document.getElementById("completed").checked;
    const priority = document.getElementById("priority").value;

    if (!title) {
        alert("Title is required");
        return;
    }

    fetch(API_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            title,
            description,
            completed,
            priority
        })
    })
        .then(() => {
            fetchTodos();

            document.getElementById("title").value = "";
            document.getElementById("desc").value = "";
            document.getElementById("completed").checked = false;
            document.getElementById("priority").value = "LOW";
        });
}

// delete todo
function deleteTodo(id) {
    fetch(`${API_URL}/${id}`, {
        method: "DELETE"
    })
        .then(fetchTodos);
}

// toggle completed
function toggleComplete(id) {
    const todo = allTodos.find(t => t.id === id);
    if (!todo) return;

    const updatedTodo = {
        ...todo,
        completed: !todo.completed
    };

    fetch(`${API_URL}/${id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(updatedTodo)
    })
        .then(fetchTodos);
}