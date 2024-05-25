const initData = [
  {
    id: "TB001",
    name: "Máy chạy bộ",
    image: "https://i.pinimg.com/564x/0a/af/a0/0aafa0c1806462d5122d3156e440ff01.jpg",
    type: "Cardio",
    purchaseDate: "2024-04-01",
    quantity: 5,
    status: "Active"
  },
  {
    id: "TB002",
    name: "Tạ đơn",
    image: "https://i.pinimg.com/564x/95/84/7f/95847fe8832d8859e386233fb993a44c.jpg",
    type: "Tạ",
    purchaseDate: "2024-04-02",
    quantity: 20,
    status: "Active"
  },
  {
    id: "TB003",
    name: "Xe đạp tập",
    image: "https://i.pinimg.com/564x/de/3e/0e/de3e0e9a15TB003a4f76c65e25dcec6e05.jpg",
    type: "Cardio",
    purchaseDate: "2024-04-01",
    quantity: 10,
    status: "Active"
  },
  {
    id: "TB004",
    name: "Máy ép ngực",
    image: "https://i.pinimg.com/564x/78/f8/b7/78f8b7661af9687b581e92089da2971b.jpg",
    type: "Sức mạnh",
    purchaseDate: "2024-04-01",
    quantity: 7,
    status: "Active"
  },
  {
    id: "TB005",
    name: "Máy kéo xô",
    image: "https://i.pinimg.com/564x/06/8d/75/068d75712ff87a458e24cf082e7ee4d8.jpg",
    type: "Sức mạnh",
    purchaseDate: "2024-04-01",
    quantity: 2,
    status: "Maintaenance"
  },
  {
    id: "TB006",
    name: "Máy gập bụng",
    image: "https://i.pinimg.com/564x/74/08/59/7408594e7fd92d03a23ce72de10904d9.jpg",
    type: "Sức mạnh",
    purchaseDate: "2024-04-01",
    quantity: 9,
    status: "Active"
  },
  {
    id: "TB007",
    name: "Máy tập chân",
    image: "https://i.pinimg.com/564x/b2/e3/ad/b2e3adf2068f661014ffcfee1b280445.jpg",
    type: "Sức mạnh",
    purchaseDate: "2024-03-27",
    quantity: 14,
    status: "Maintaenance"
  },
  {
    id: "TB008",
    name: "Bóng tập thể lực",
    image: "https://th.bing.com/th/id/OIP.xJ3Y0Pcpo7rTf_m7iTla-AHaHa?w=980&h=980&rs=1&pid=ImgDetMain",
    type: "Cardio",
    purchaseDate: "2024-02-19",
    quantity: 25,
    status: "Active"
  }
]

// Lấy phần tử tbody của bảng
const tableBody = document.querySelector('#my-table tbody');

// Hàm để tạo một hàng của bảng
function createTableRow(data) {
  const row = document.createElement('tr');

  const idCell = document.createElement('td');
  idCell.textContent = data.id;
  row.appendChild(idCell);

  const nameCell = document.createElement('td');
  nameCell.textContent = data.name;
  row.appendChild(nameCell);

  const imageCell = document.createElement('td');
  const img = document.createElement('img');
  img.src = data.image;
  img.alt = "#";
  img.style.width = '50px'; // Đặt chiều rộng của hình ảnh
  imageCell.appendChild(img);
  row.appendChild(imageCell);

  const typeCell = document.createElement('td');
  typeCell.textContent = data.type;
  row.appendChild(typeCell);

  const purchaseDataCell = document.createElement('td');
  purchaseDataCell.textContent = data.purchaseData;
  row.appendChild(purchaseDataCell);

  const quantityCell = document.createElement('td');
  quantityCell.textContent = data.quantity;
  row.appendChild(quantityCell);

  const statusCell = document.createElement('td');
  statusCell.textContent = data.status;
  row.appendChild(statusCell);

  return row;
}

// Lặp qua mảng dữ liệu và thêm các hàng vào bảng
initData.forEach(
  item => {
    tableBody.appendChild(createTableRow(item))
})