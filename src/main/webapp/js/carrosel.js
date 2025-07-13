function scrollLeft(id) {
  const c = document.getElementById(id);
  c.scrollBy({ left: -c.clientWidth + 100, behavior: 'smooth' });
}

function scrollRight(id) {
  const c = document.getElementById(id);
  c.scrollBy({ left: c.clientWidth - 100, behavior: 'smooth' });
}

function updateButtons(id) {
  const c = document.getElementById(id);
  const leftBtn = c.parentElement.querySelector(".scroll-btn.left");
  const rightBtn = c.parentElement.querySelector(".scroll-btn.right");
  const maxScroll = c.scrollWidth - c.clientWidth;

  leftBtn.classList.toggle("disabled", c.scrollLeft <= 10);
  rightBtn.classList.toggle("disabled", c.scrollLeft >= maxScroll - 10);
}

window.addEventListener("load", () => {
  document.querySelectorAll(".scroll-container").forEach(c => {
    updateButtons(c.id);
    c.addEventListener("scroll", () => updateButtons(c.id));
  });
});
