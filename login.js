// Función para cambiar entre pestañas
    function showForm(formId) {
      document.querySelectorAll('.form').forEach(f => f.classList.remove('active'));
      document.querySelectorAll('.tab').forEach(t => t.classList.remove('active'));
      document.getElementById(formId).classList.add('active');
      document.querySelector(`.tab[onclick="showForm('${formId}')"]`).classList.add('active');
    }

    // Redirección al Main al ingresar con éxito
    function manejarLogin(event) {
      event.preventDefault(); 
      // Si pasa las validaciones de HTML, redirige a main.html
      window.location.href = 'main.html';
    }

    // Redirección interna a la pestaña de Login al registrarse con éxito
    function manejarRegistro(event) {
      event.preventDefault();
      
      // Mensaje opcional para avisar al usuario que se registró con éxito
      alert("¡Usuario registrado con éxito! Ahora puedes iniciar sesión.");
      
      // Limpia los campos del formulario de registro (buena práctica)
      document.getElementById('register').reset();
      
      // Te lleva visualmente al formulario de Login
      showForm('login');
    }