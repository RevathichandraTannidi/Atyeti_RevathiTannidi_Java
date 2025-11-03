
async function loadSummary() {
  try {
    const res = await fetch(`${BASE_URL}/api/attendance/summary/today`);
    const data = await res.json();
    document.getElementById("totalStudents").innerText = data.totalStudents || 0;
    document.getElementById("present").innerText = data.present || 0;
    document.getElementById("absent").innerText = data.absent || 0;
    document.getElementById("leave").innerText = data.leave || 0;
  } catch (err) {
    console.error("Error loading summary:", err);
  }
}


async function loadStudents() {
  try {
    const res = await fetch(`${BASE_URL}/api/admin/students`);
    const students = await res.json();
    const tbody = document.getElementById("studentList");
    tbody.innerHTML = "";

    students.forEach(s => {
      const tr = document.createElement("tr");
      tr.innerHTML = `
        <td>${s.name}</td>
        <td>${s.email}</td>
        <td>
          <button class="btn btn-success btn-sm" onclick="markAttendance(${s.id}, 'PRESENT')">Present</button>
          <button class="btn btn-danger btn-sm" onclick="markAttendance(${s.id}, 'ABSENT')">Absent</button>
          <button class="btn btn-warning btn-sm" onclick="markAttendance(${s.id}, 'LEAVE')">Leave</button>
        </td>`;
      tbody.appendChild(tr);
    });
  } catch (err) {
    console.error("Error loading students:", err);
  }
}


async function markAttendance(studentId, status) {
  try {
    const res = await fetch(`${BASE_URL}/api/attendance/mark/${studentId}?status=${status}`, {
      method: "POST"
    });

    if (res.ok) {
      alert(`Marked ${status} for student ID ${studentId}`);
      loadSummary();
    } else {
      alert("Failed to mark attendance.");
    }
  } catch (err) {
    console.error("Error marking attendance:", err);
  }
}


async function loadLeaveRequests() {
  try {
    const res = await fetch(`${BASE_URL}/api/leaves/admin/all`);
    const leaves = await res.json();
    const tbody = document.getElementById("leaveRequests");
    tbody.innerHTML = "";

    leaves.forEach(leave => {
      const row = document.createElement("tr");
      row.innerHTML = `
        <td>${leave.student?.name || "Unknown"}</td>
        <td>${leave.reason}</td>
        <td>${leave.status}</td>
        <td>
          <button class="btn btn-success btn-sm" onclick="updateLeave(${leave.id}, 'APPROVED')">Approve</button>
          <button class="btn btn-danger btn-sm" onclick="updateLeave(${leave.id}, 'REJECTED')">Reject</button>
        </td>`;
      tbody.appendChild(row);
    });
  } catch (err) {
    console.error("Error loading leave requests:", err);
  }
}


async function updateLeave(id, status) {
  await fetch(`${BASE_URL}/api/leaves/admin/${id}?status=${status}`, { method: "PUT" });
  loadLeaveRequests();
  loadSummary();
}

function logout() {
  localStorage.clear();
  location.href = "index.html";
}


loadSummary();
loadStudents();
loadLeaveRequests();
