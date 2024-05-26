const initData = [
  {
    id: "TB001",
    name: "Máy chạy bộ",
    type: "Cardio",
    purchaseDate: "2024-04-01",
    quantity: 5,
    status: "Active"
  },
  {
    id: "TB002",
    name: "Tạ đơn",
    type: "Tạ",
    purchaseDate: "2024-04-02",
    quantity: 20,
    status: "Active"
  },
  {
    id: "TB003",
    name: "Xe đạp tập",
    type: "Cardio",
    purchaseDate: "2024-04-01",
    quantity: 10,
    status: "Active"
  },
  {
    id: "TB004",
    name: "Máy ép ngực",
    type: "Sức mạnh",
    purchaseDate: "2024-04-01",
    quantity: 7,
    status: "Active"
  },
  {
    id: "TB005",
    name: "Máy kéo xô",
    type: "Sức mạnh",
    purchaseDate: "2024-04-01",
    quantity: 2,
    status: "Maintaenance"
  },
  {
    id: "TB006",
    name: "Máy gập bụng",
    type: "Sức mạnh",
    purchaseDate: "2024-04-01",
    quantity: 9,
    status: "Active"
  },
  {
    id: "TB007",
    name: "Máy tập chân",
    type: "Sức mạnh",
    purchaseDate: "2024-03-27",
    quantity: 14,
    status: "Maintaenance"
  },
  {
    id: "TB008",
    name: "Bóng tập thể lực",
    type: "Cardio",
    purchaseDate: "2024-02-19",
    quantity: 25,
    status: "Active"
  }
]

function getData() {
  const dataString = localStorage.getItem("device")
  return JSON.parse(dataString)
}

function setData(data) {
  localStorage.setItem("device", JSON.stringify(data))
}

//initial 
function initial() {
  let device = getData()
  if (!device) {
    setData(initData)
    device = getData()
  }
  renderTable(device)
}

// Lấy phần tử tbody của bảng
const tableBody = document.querySelector('#my-table tbody');

function deleteTable() {
  const arr = document.querySelectorAll('tbody tr')
  if (arr.length) {
    arr.forEach((tableRow) => tableBody.removeChild(tableRow))
  }
}

function removeDevice(id) {
  let devices = getData()
  devices = devices.filter(device => device.id !== id);
  setData(devices)
  deleteTable()
  renderTable(devices)
}

// Hàm để tạo một hàng của bảng
function createTableRow(data) {
  const row = document.createElement('tr');

  const idCell = document.createElement('td');
  idCell.textContent = data.id;
  row.appendChild(idCell);

  const nameCell = document.createElement('td');
  nameCell.textContent = data.name;
  row.appendChild(nameCell);

  const typeCell = document.createElement('td');
  typeCell.textContent = data.type;
  row.appendChild(typeCell);

  const purchaseDateCell = document.createElement('td');
  purchaseDateCell.textContent = data.purchaseDate;
  row.appendChild(purchaseDateCell);

  const quantityCell = document.createElement('td');
  quantityCell.textContent = data.quantity;
  row.appendChild(quantityCell);

  const statusCell = document.createElement('td');
  statusCell.textContent = data.status;
  row.appendChild(statusCell);

  const actionCell = document.createElement('td')
  const deleteBtn = document.createElement('button')
  deleteBtn.setAttribute('id', `${data.id}`)
  const img1 = document.createElement('img');
  img1.src = "/image/trash.png";
  img1.alt = "#";
  img1.style.width = '20px';
  deleteBtn.appendChild(img1)
  actionCell.appendChild(deleteBtn);
  row.appendChild(actionCell);

  deleteBtn.onclick = (e) => {
    let id = e.currentTarget.id
    console.log(e.currentTarget)
    removeDevice(id)
  }
  return row;
}

const renderTable = (data) => {
  data.forEach(
    item => {
      tableBody.appendChild(createTableRow(item))
    })
}

initial()