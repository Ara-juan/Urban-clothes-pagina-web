/**
 * Alterna la visibilidad entre los formularios de Login y Registro
 * @param {string} formId - ID del formulario a mostrar ('acceder' o 'registrarse')
 */
function showForm(formId) {
  const forms = document.querySelectorAll('.form');
  const tabs = document.querySelectorAll('.tab');

  // Ocultar todos los formularios y desactivar pestañas
  forms.forEach(form => form.classList.remove('active'));
  tabs.forEach(tab => tab.classList.remove('active'));

  // Activar el formulario seleccionado
  const selectedForm = document.getElementById(formId);
  if (selectedForm) {
    selectedForm.classList.add('active');
  }

  // Activar la pestaña correspondiente según la función asociada a su onclick
  tabs.forEach(tab => {
    if (tab.getAttribute('onclick') && tab.getAttribute('onclick').includes(formId)) {
      tab.classList.add('active');
    }
  });
}

/**
 * Procesa el inicio de sesión del usuario
 * @param {Event} event - Evento del formulario
 */
function manejarLogin(event) {
  event.preventDefault();

  // Si pasa las validaciones HTML5 del formulario, redirige al catálogo principal
  window.location.href = 'main.html';
}

/**
 * Procesa el registro de un nuevo usuario
 * @param {Event} event - Evento del formulario
 */
function manejarRegistro(event) {
  event.preventDefault();

  alert("¡Usuario registrado con éxito! Ahora puedes iniciar sesión.");

  // Limpia los campos del formulario de registro
  const registerForm = document.getElementById('register');
  if (registerForm) {
    registerForm.reset();
  }

  // Cambia automáticamente a la pestaña de Iniciar Sesión
  showForm('login');
}