function toggleMode() {
  document.body.classList.toggle("dark-mode");
}

function validateLogin() {
  const user = document.getElementById('username').value;
  const pass = document.getElementById('password').value;
  if (user === 'admin' && pass === 'admin') {
    alert('Login successful!');
    return true;
  } else {
    alert('Invalid credentials');
    return false;
  }
}

document.addEventListener('DOMContentLoaded', () => {
  const search = document.getElementById('search');
  if (search) {
    search.addEventListener('keyup', function () {
      const filter = search.value.toLowerCase();
      const services = document.querySelectorAll('#services-list li');
      services.forEach(li => {
        const text = li.textContent.toLowerCase();
        li.style.display = text.includes(filter) ? '' : 'none';
      });
    });
  }
});
