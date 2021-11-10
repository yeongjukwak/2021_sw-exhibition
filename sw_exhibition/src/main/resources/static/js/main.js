'use strict';

// Projects
const workBtnContainer = document.querySelector('.work__categories');
const projectContainer = document.querySelector('.work__projects');
const projects = document.querySelectorAll('.project');
workBtnContainer.addEventListener('click', (event) => {
  const filter = event.target.dataset.filter || event.target.parentNode.dataset.filter;
  if (filter == null) {
    return;
  }
  
  // Remove selection from the previous item and select the new one
  const active = document.querySelector('.category__btn.selected');
  active.classList.remove('selected');
  const target =
    event.target.nodeName === 'BUTTON' ? event.target : event.target.parentNode;
  target.classList.add('selected');

  projectContainer.classList.add('anim-out');
  setTimeout(() => {
    projects.forEach((project) => {
      console.log(project.dataset.type);
      if (filter === '*' || filter === project.dataset.type) {
        project.classList.remove('invisible');
      } else {
        project.classList.add('invisible');
      }
    });
    projectContainer.classList.remove('anim-out');
  }, 300);
});

// function openPopup() {
//   var _width = '650';
//   var _height = '380';

//   // 팝업을 가운데 위치시키기 위해 아래와 같이 값 구하기
//   var _left = Math.ceil(( window.screen.width - _width )/2);
//   var _top = Math.ceil(( window.screen.height - _height )/2); 

//   window.open('/url', 'popup-test', 'width='+ _width +', height='+ _height +', left=' + _left + ', top='+ _top )
// };

// const content = document.querySelector('.contents');
// const popup = document.querySelector('.popup');

// content.addEventListener(('click'), () => {
//   popup.fadeIn();
// });