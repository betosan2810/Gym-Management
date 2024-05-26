// delete handler
var dclosebtn = document.getElementById('dclosebtn')
var deletewrapper = document.querySelector('.deletewrapper')
var dconfirmbtn = document.getElementById('dconfirmbtn')
var dcancelbtn = document.getElementById('dcancelbtn')
var fopenbtn = document.getElementById('fopenbtn')
var form = document.querySelector('.addwrapper')
var fclosebtn = document.querySelector('#fclosebtn')
var fsubmitbtn = document.getElementById('fsubmitbtn')

function toggleForm() {
  form.classList.toggle('hide')
}

fsubmitbtn.addEventListener('click', (e) => {
  e.preventDefault()
  const devices = getData()
  const deviceId = document.getElementById('ma-thiet-bi').value
  const existingIds = devices.map(item => item.id);
  if (existingIds.includes(deviceId)) {
    alert("Error: ID đã tồn tại!");
    return;
  }
  const deviceName = document.getElementById('ten-thiet-bi').value
  const deviceType = document.getElementById('loai-thiet-bi').value
  const devicePurchaseDate = document.getElementById('ngay-mua').value
  const deviceQuantity = document.getElementById('so-luong').value
  const deviceStatus = document.getElementById('tinh-trang').value
  
  const newDevice = {
    id: deviceId,
    name: deviceName,
    type: deviceType,
    purchaseDate: devicePurchaseDate,
    quantity: deviceQuantity,
    status: deviceStatus
  }
  devices.push(newDevice)
  setData(devices)
  deleteTable()
  renderTable(devices)
  toggleForm()
})

fopenbtn.addEventListener('click', toggleForm)

fclosebtn.addEventListener('click', toggleForm)

function toggleDelete() {
  deletewrapper.classList.toggle('hide')
}

dclosebtn.addEventListener('click', toggleDelete)

dcancelbtn.addEventListener('click', toggleDelete)

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
    let deleteDeviceName = document.getElementById('delete-device-name')
    deleteDeviceName.innerText = data.name
    toggleDelete()
    dconfirmbtn.onclick = () => {
      toggleDelete()
      removeDevice(id)
    }
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