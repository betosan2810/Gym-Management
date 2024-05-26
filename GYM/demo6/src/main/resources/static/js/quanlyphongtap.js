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
  const gymRooms = getData()
  const gymRoomId = document.getElementById('ma-phong-tap').value
  const existingIds = gymRooms.map(item => item.id);
  if (existingIds.includes(gymRoomId)) {
    alert("Error: ID đã tồn tại!");
    return;
  }
  const gymRoomName = document.getElementById('ten-phong-tap').value
  const gymRoomAddress = document.getElementById('dia-chi').value

  const newGymRoom = {
    id: gymRoomId,
    name: gymRoomName,
    address: gymRoomAddress
  }
  gymRooms.push(newGymRoom)
  setData(gymRooms)
  deleteTable()
  renderTable(gymRooms)
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
    id: 'PT001',
    name: 'Phòng Cardio',
    address: '123 Đường Sức Khỏe, Quận 1, TP. Hồ Chí Minh, Việt Nam'
  },
  {
    id: 'PT002',
    name: 'Phòng Sức Mạnh',
    address: '456 Đường Thể Hình, Quận Ngũ Hành Sơn, Đà Nẵng, Việt Nam'
  },
  {
    id: 'PT003',
    name: 'Phòng Yoga',
    address: '789 Đường Thư Giãn, Quận 3, TP. Hà Nội, Việt Nam'
  },
  {
    id: 'PT004',
    name: 'Phòng Aerobic',
    address: '101 Đường Vũ Điệu, Quận Ninh Kiều, Cần Thơ, Việt Nam'
  },
  {
    id: 'PT005',
    name: 'Phòng Tập Tạ',
    address: '202 Đường Thư Giãn, TP. Hải Phòng, Việt Nam'
  },
  {
    id: 'PT006',
    name: 'Phòng Boxing',
    address: '303 Đường Võ Thuật, TP. Huế, Thừa Thiên Huế, Việt Nam'
  },
  {
    id: 'PT007',
    name: 'Phòng Thể Lực',
    address: '404 Đường Bơi Lội, TP. Nha Trang, Khánh Hòa, Việt Nam'
  },
  {
    id: 'PT008',
    name: 'Phòng Pilates',
    address: '505 Đường Thể Dục, TP. Đà Lạt, Lâm Đồng, Việt Nam'
  },
  {
    id: 'PT009',
    name: 'Phòng Zumba',
    address: '606 Đường Khiêu Vũ, TP. Vinh, Nghệ An, Việt Nam'
  },
  {
    id: 'PT010',
    name: 'Phòng CrossFit',
    address: '707 Đường Tập Luyện, TP. Buôn Ma Thuột, Đắk Lắk, Việt Nam'
  },
  {
    id: 'PT011',
    name: 'Phòng Cardio',
    address: '123 Fitness St., District 1, Ho Chi Minh City, Vietnam'
  },
  {
    id: 'PT012',
    name: 'Phòng Sức Mạnh',
    address: '456 Gym Ave., Marina Bay, Singapore'
  },
  {
    id: 'PT013',
    name: 'Phòng Yoga',
    address: '789 Relax Rd., Central, Hong Kong'
  },
  {
    id: 'PT014',
    name: 'Phòng Aerobic',
    address: '101 Dance Ln., Shibuya, Tokyo, Japan'
  },
  {
    id: 'PT015',
    name: 'Phòng Warm Up',
    address: '202 Wellness Blvd., Manhattan, New York, USA'
  },
  {
    id: 'PT016',
    name: 'Phòng Boxing',
    address: '303 Fight St., Kensington, London, UK'
  },
  {
    id: 'PT017',
    name: 'Phòng Seeking',
    address: '404 Swim Rd., Bondi Beach, Sydney, Australia'
  },
  {
    id: 'PT018',
    name: 'Phòng Pilates',
    address: '505 Flex St., Mitte, Berlin, Germany'
  },
  {
    id: 'PT019',
    name: 'Phòng Zumba',
    address: '606 Dance Ave., Ipanema, Rio de Janeiro, Brazil'
  },
  {
    id: 'PT020',
    name: 'Phòng CrossFit',
    address: '707 Workout Blvd., Downtown, Toronto, Canada'
  }
];

function getData() {
  const dataString = localStorage.getItem("gymRooms")
  return JSON.parse(dataString)
}

function setData(data) {
  localStorage.setItem("gymRooms", JSON.stringify(data))
}

//initial 
function initial() {
  let gymRooms = getData()
  if (!gymRooms) {
    setData(initData)
    gymRooms = getData()
  }
  renderTable(gymRooms)
}

// Lấy phần tử tbody của bảng
const tableBody = document.querySelector('#my-table tbody');

function deleteTable() {
  const arr = document.querySelectorAll('tbody tr')
  if (arr.length) {
    arr.forEach((tableRow) => tableBody.removeChild(tableRow))
  }
}

function removeGymRoom(id) {
  let gymRooms = getData()
  gymRooms = gymRooms.filter(gymRoom => gymRoom.id !== id);
  setData(gymRooms)
  deleteTable()
  renderTable(gymRooms)
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

  const addressCell = document.createElement('td');
  addressCell.textContent = data.address;
  row.appendChild(addressCell);

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
    let deleteGymRoomName = document.getElementById('delete-gym-name')
    deleteGymRoomName.innerText = data.name
    toggleDelete()
    dconfirmbtn.onclick = () => {
      toggleDelete()
      removeGymRoom(id)
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