const initData = [
  {
    feedback: "Phòng tập rất sạch sẽ và được trang bị đầy đủ các máy móc tập luyện.",
    rating: 4.5
  },
  {
    feedback: "Nhân viên tư vấn rất nhiệt tình và hướng dẫn cách sử dụng các thiết bị một cách chi tiết.",
    rating: 5
  },
  {
    feedback: "Các lớp tập như yoga, kickboxing và Zumba rất đa dạng và được tổ chức thường xuyên.",
    rating: 4
  },
  {
    feedback: "Giá cả các gói tập hợp lý và có nhiều lựa chọn phù hợp với mọi đối tượng.",
    rating: 4.2
  },
  {
    feedback: "Không gian tập rộng rãi, thoáng mát và có cả khu vực xông hơi để nghỉ ngơi sau tập.",
    rating: 4.8
  },
  {
    feedback: "Cần cải thiện hệ thống máy lạnh và thêm các tủ locker để khách hàng có thể cất đồ an toàn.",
    rating: 3.5
  },
  {
    feedback: "Một số máy tập đã cũ và cần được thay thế hoặc bảo trì thường xuyên hơn.",
    rating: 3.8
  },
  {
    feedback: "Đôi khi phải chờ lâu để sử dụng một số máy tập vào giờ cao điểm.",
    rating: 4
  }
];

function getData() {
  const dataString = localStorage.getItem("feedbacks")
  return JSON.parse(dataString)
}

function setData(data) {
  localStorage.setItem("feedbacks", JSON.stringify(data))
}

const feedbackContainer = document.getElementById("container")
const renderFeedbacks = (feedbacks) => {
  feedbacks.forEach(feedback => {
    const feedbackCard = document.createElement('div');
    feedbackCard.classList.add('feedback-item');

    const feedbackText = document.createElement('p');
    feedbackText.textContent = feedback.feedback;

    const ratingText = document.createElement('p');
    ratingText.classList.add('rating');
    ratingText.textContent = `Đánh giá: ${feedback.rating} sao`;

    feedbackCard.appendChild(feedbackText);
    feedbackCard.appendChild(ratingText);
    feedbackContainer.appendChild(feedbackCard);
  });
}



//initial 
function initial() {
  let feedbacks = getData()
  if (!feedbacks) {
    setData(initData)
    feedbacks = getData()
  }
  renderFeedbacks(feedbacks)
}

initial()


