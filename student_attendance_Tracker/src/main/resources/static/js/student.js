
const user = JSON.parse(localStorage.getItem("user"));

if (!user) {
  alert("Please log in first.");
  location.href = "index.html";
}

document.getElementById("studentName").innerText = `Welcome, ${user.name}`;


async function markAttendance(status) {
  try {
    const res = await fetch(`${BASE_URL}/api/attendance/mark/${user.id}?status=${status}`, {
      method: "POST"
    });

    if (res.ok) {
      alert(`Attendance marked as ${status}`);
      loadMyLeaves();
    } else {
      const msg = await res.text();
      alert(`Failed to mark attendance: ${msg}`);
    }
  } catch (err) {
    console.error("Error marking attendance:", err);
    alert("Server error while marking attendance.");
  }
}

async function requestLeave() {
  const reason = prompt("Enter reason for leave:");
  if (!reason) return;

  try {
    const res = await fetch(`${BASE_URL}/api/leaves/student/${user.id}?reason=${encodeURIComponent(reason)}`, {
      method: "POST"
    });

    if (res.ok) {
      alert("Leave request submitted!");
      loadMyLeaves();
    } else {
      const msg = await res.text();
      alert(`Failed to submit leave: ${msg}`);
    }
  } catch (err) {
    console.error("Error submitting leave:", err);
    alert("Server error while submitting leave request.");
  }
}


async function loadMyLeaves() {
  try {
    const res = await fetch(`${BASE_URL}/api/leaves/student/${user.id}`);
    if (!res.ok) throw new Error("Failed to load leave data.");

    const leaves = await res.json();
    const list = document.getElementById("myLeaves");
    list.innerHTML = "";

    if (leaves.length === 0) {
      list.innerHTML = `<li class="list-group-item text-muted">No leave requests yet.</li>`;
      return;
    }

    leaves.forEach(l => {
      const li = document.createElement("li");
      li.className = "list-group-item";
      li.innerText = `${l.reason} - ${l.status}`;
      list.appendChild(li);
    });
  } catch (err) {
    console.error("Error loading leaves:", err);
    alert("Server error while fetching leave data.");
  }
}

function logout() {
  localStorage.clear();
  location.href = "index.html";
}

loadMyLeaves();
