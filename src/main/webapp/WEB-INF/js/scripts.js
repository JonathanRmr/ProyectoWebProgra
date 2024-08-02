document.addEventListener("DOMContentLoaded", () => {
    fetchClientes();

    document.getElementById("form-cliente").addEventListener("submit", function(event) {
        event.preventDefault();
        const id = document.getElementById("cliente-id").value;
        const nombre = document.getElementById("nombre").value;
        const email = document.getElementById("email").value;

        if (id) {
            updateCliente(id, { nombre, email });
        } else {
            addCliente({ nombre, email });
        }
    });
});

function fetchClientes() {
    fetch("/api/clientes")
        .then(response => response.json())
        .then(data => {
            const tbody = document.getElementById("clientes-tbody");
            tbody.innerHTML = "";
            data.forEach(cliente => {
                const tr = document.createElement("tr");
                tr.innerHTML = `
                    <td>${cliente.nombre}</td>
                    <td>${cliente.email}</td>
                    <td>
                        <button onclick="editCliente('${cliente.id}', '${cliente.nombre}', '${cliente.email}')">Editar</button>
                        <button onclick="deleteCliente('${cliente.id}')">Eliminar</button>
                    </td>
                `;
                tbody.appendChild(tr);
            });
        });
}

function addCliente(cliente) {
    fetch("/api/clientes", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(cliente)
    }).then(() => {
        resetForm();
        fetchClientes();
    });
}

function updateCliente(id, cliente) {
    fetch(`/api/clientes/${id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(cliente)
    }).then(() => {
        resetForm();
        fetchClientes();
    });
}

function deleteCliente(id) {
    fetch(`/api/clientes/${id}`, {
        method: "DELETE"
    }).then(() => {
        fetchClientes();
    });
}

function editCliente(id, nombre, email) {
    document.getElementById("cliente-id").value = id;
    document.getElementById("nombre").value = nombre;
    document.getElementById("email").value = email;
    document.getElementById("submit-button").textContent = "Actualizar Cliente";
}

function resetForm() {
    document.getElementById("form-cliente").reset();
    document.getElementById("cliente-id").value = "";
    document.getElementById("submit-button").textContent = "Agregar Cliente";
}
