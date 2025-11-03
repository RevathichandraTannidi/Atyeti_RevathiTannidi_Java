
const urlParams = new URLSearchParams(window.location.search);
const role = urlParams.get("role") || "STUDENT";
document.getElementById("loginTitle").innerText = `${role} Login`;

document.getElementById("loginForm").addEventListener("submit", async (e) => {
  e.preventDefault();

  const email = document.getElementById("email").value.trim();
  const password = document.getElementById("password").value.trim();

  if (!email || !password) {
    document.getElementById("loginError").innerText = "Please fill in all fields.";
    return;
  }

  try {
    const res = await fetch(`${BASE_URL}/api/auth/login`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ email, password }),
    });

    const data = await res.json();


    const user = data.user || data;

    if (res.ok && user) {
      localStorage.setItem("user", JSON.stringify(user));

      if (user.role === "ADMIN") {
        location.href = "admin-dashboard.html";
      } else if (user.role === "STUDENT") {
        location.href = "student-dashboard.html";
      } else {
        document.getElementById("loginError").innerText = "Unknown role.";
      }
    } else {
      document.getElementById("loginError").innerText = data.message || "Invalid credentials.";
    }
  } catch (err) {
    document.getElementById("loginError").innerText = "Server error. Please try again later.";
    console.error("Login error:", err);
  }
});
