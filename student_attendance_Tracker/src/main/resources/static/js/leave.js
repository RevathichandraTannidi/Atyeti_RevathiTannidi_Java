
async function loadLeaveRequests() {
  try {
    const res = await fetch(`${BASE_URL}/api/leaves/admin/all`);
    const leaves = await res.json();

    const tbody = document.getElementById("leaveRequests");
    if (!tbody) return;
    tbody.innerHTML = "";

    leaves.forEach(leave => {
      const tr = document.createElement("tr");
      tr.innerHTML = `
        <td>${leave.student.name}</td>
        <td>${leave.reason}</td>
        <td>${leave.status}</td>
        <td>
          <button class="btn btn-success btn-sm" onclick="updateLeaveStatus(${leave.id}, 'APPROVED')">Approve</button>
          <button class="btn btn-danger btn-sm" onclick="updateLeaveStatus(${leave.id}, 'REJECTED')">Reject</button>
        </td>`;
      tbody.appendChild(tr);
    });
  } catch (err) {
    console.error("Error loading leave requests:", err);
  }
}


async function updateLeaveStatus(leaveId, status) {
  try {
    await fetch(`${BASE_URL}/api/leaves/admin/${leaveId}?status=${status}`, { method: "PUT" });
    loadLeaveRequests();
  } catch (err) {
    console.error("Error updating leave:", err);
  }
}


async function loadMyLeaves(studentId) {
  try {
    const res = await fetch(`${BASE_URL}/api/leaves/student/${studentId}`);
    const leaves = await res.json();
    const list = document.getElementById("myLeaves");
    if (!list) return;
    list.innerHTML = "";

    leaves.forEach(l => {
      const li = document.createElement("li");
      li.className = "list-group-item";
      li.textContent = `${l.reason} - ${l.status}`;
      list.appendChild(li);
    });
  } catch (err) {
    console.error("Error fetching my leaves:", err);
  }
}
