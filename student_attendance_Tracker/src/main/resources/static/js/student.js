// student.js

async function login() {
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    try {
        const res = await fetch("/api/auth/login", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ email, password })
        });

        if (!res.ok) throw new Error("Login failed");

        const user = await res.json();

        if (user.role === "ADMIN") {
            window.location.href = "/admin-dashboard.html";
        } else {
            window.location.href = "/student-dashboard.html";
        }
    } catch (err) {
        alert("Invalid credentials");
        console.error(err);
    }
}

async function loadStudents() {
    const res = await fetch("/api/admin/students");
    const students = await res.json();

    const tbody = document.querySelector("#studentTable tbody");
    tbody.innerHTML = "";

    students.forEach(s => {
        const row = `
            <tr>
                <td>${s.name}</td>
                <td>${s.rollNumber}</td>
                <td>${s.email}</td>
                <td>${s.role}</td>
            </tr>`;
        tbody.innerHTML += row;
    });
}
