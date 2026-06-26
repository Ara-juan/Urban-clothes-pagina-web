// script.js
function scrollCarousel(button, direction) {
  // Encuentra el contenedor de productos de este carrusel específico
  const container = button.parentElement.querySelector('.products');
  
  // Detecta el ancho visible actual del contenedor (el espacio de los 3 productos)
  const containerWidth = container.offsetWidth;
  
  // Multiplicamos el ancho total por la dirección (1 o -1)
  // Restamos un pequeño porcentaje para que el scroll no sea tan brusco y quede alineado
  const scrollAmount = containerWidth * direction;
  
  // Aplica el movimiento suave
  container.scrollBy({
    left: scrollAmount,
    behavior: 'smooth'
  });
}

document.addEventListener("DOMContentLoaded", () => {
  const cards = document.querySelectorAll(".card");
  const modal = document.getElementById("product-modal");
  const closeModal = document.querySelector(".close-modal");
  
  // Elementos internos del modal
  const modalImg = document.getElementById("modal-img");
  const modalTitle = document.getElementById("modal-title");
  const modalPrice = document.getElementById("modal-price");
  const modalDesc = document.getElementById("modal-desc");

  // Abrir modal al hacer clic en una tarjeta
  cards.forEach(card => {
    card.addEventListener("click", () => {
      const imgUrl = card.querySelector("img").src;
      const title = card.querySelector("h3").innerText;
      const price = card.querySelector(".price").innerText;
      
      // Captura la descripción personalizada desde el atributo data-desc
      // Si te olvidas de poner el atributo en alguna tarjeta, mostrará un texto por defecto
      const descPersonalizada = card.getAttribute("data-desc") || "Este producto no cuenta con una descripción detallada todavía.";

      // Asignar los valores capturados a los elementos del modal
      modalImg.src = imgUrl;
      modalTitle.innerText = title;
      modalPrice.innerText = price;
      modalDesc.innerText = descPersonalizada;

      // Mostrar el modal agregando la clase 'show'
      modal.classList.add("show");
    });
  });

  // Cerrar modal al darle a la X
  closeModal.addEventListener("click", () => {
    modal.classList.remove("show");
  });

  // Cerrar modal si se hace clic afuera del recuadro del contenido
  window.addEventListener("click", (e) => {
    if (e.target === modal) {
      modal.classList.remove("show");
    }
  });
});