const text_wrapper = document.querySelector('.text-wrapper');
const input_writer = document.querySelector('#writer');
const input_text = document.querySelector('#content');
const input_btn = document.querySelector('.input-btn');

/* 방명록 리스트 가져오기 */
function guestbookList() {
    $.ajax({
        type: "GET",
        url: "/guestbook/list",
        dataType: "json",
        success : function (response) {
            if(response.status === "200") {
                let item1 = "";
                for(let i=0; i<response.data.length; i++) {
                    // 2. 새로운 아이템을 만든다.
                    item1 = createItem(response.data[i].guest_writer, response.data[i].guest_content, response.data[i].guest_date);
                    // 3. text-wrapper 컨테이너 안에 새로 만든 아이템을 추가한다.
                    text_wrapper.appendChild(item1);
                }
            }
        },
        error : function (err) {
            console.log(err);
        }
    });
}

function onAdd() {
  // 1. 사용자가 입력한 텍스트를 받아온다.
  const writer = input_writer.value;
  const text = input_text.value;

  if(text === '' || writer === '') {
    input_writer.focus();
    return;
  }

  /* 방명록 등록 */
  let inputData = {"guest_writer" : writer, "guest_content" : text};
  $.ajax({
      type: "POST",
      url: "/guestbook/add",
      contentType: 'application/json; charset=utf-8',
      data: JSON.stringify(inputData),
      success : function (response) {
          // 댓글 리스트 새로고침
          while (text_wrapper.hasChildNodes()) {
              text_wrapper.removeChild(text_wrapper.firstChild);
          }
          guestbookList();

          // 4. input 을 초기화 한다.
          input_writer.value = '';
          input_text.value = '';
          input_writer.focus();
      },
      error : function (err) {
          alert(err.responseJSON.data);
      }
  });
}

function createItem(writer, text, date) {
    const itemBox = document.createElement('div');
    itemBox.setAttribute('class', 'text');

    const itemBox_inner1 = document.createElement('div');
    itemBox_inner1.setAttribute('class', 'text__writer');

    const item_1 = document.createElement('span');
    item_1.innerText = writer;

    const itemBox_inner2 = document.createElement('div');
    itemBox_inner2.setAttribute('class', 'text__content');

    const item_2 = document.createElement('span');
    item_2.innerText = text;

    const itemBox_inner3 = document.createElement('div');
    itemBox_inner3.setAttribute('class', 'now_time');

    const item_3 = document.createElement('span');
    item_3.innerText = date;

    itemBox.appendChild(itemBox_inner1);
    itemBox_inner1.appendChild(item_1);
    itemBox.appendChild(itemBox_inner2);
    itemBox_inner2.appendChild(item_2);
    itemBox.appendChild(itemBox_inner3);
    itemBox_inner3.appendChild(item_3);

    return itemBox;
}

input_btn.addEventListener('click', () => {
  onAdd();
});
