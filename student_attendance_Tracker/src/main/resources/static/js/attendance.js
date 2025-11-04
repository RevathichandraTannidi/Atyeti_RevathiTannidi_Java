
async function loadAttendanceSummary() {
  try {
    const res = await fetch(`${BASE_URL}/api/attendance/summary/today`);
    const data = await res.json();

    document.getElementById("totalStudents").innerText = data.totalStudents;
    document.getElementById("present").innerText = data.present;
    document.getElementById("absent").innerText = data.absent;
    document.getElementById("leave").innerText = data.leave;
  } catch (err) {
    console.error("Error fetching attendance summary:", err);
  }
}


async function loadTodayAttendanceList() {
  try {
    const res = await fetch(`${BASE_URL}/api/attendance/today`);
    const data = await res.json();

    const table = document.getElementById("attendanceList");
    if (!table) return;
    table.innerHTML = "";

    data.forEach(a => {
      const tr = document.createElement("tr");
      tr.innerHTML = `
        <td>${a.student.name}</td>
        <td>${a.status}</td>
        <td>${new Date(a.date).toLocaleDateString()}</td>`;
      table.appendChild(tr);
    });
  } catch (err) {
    console.error("Error fetching today's attendance list:", err);
  }
}
