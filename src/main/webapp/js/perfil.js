document.addEventListener("DOMContentLoaded", () => {
  // Inicializa userData vazio ou tenta carregar do localStorage
  let userData = JSON.parse(localStorage.getItem('userData')) || {
    nome: "",
    dataNasc: "",
    email: "",
    senha: ""
  };

  const profileView = document.getElementById('profile-view');
  const profileEdit = document.getElementById('profile-edit');

  const viewNome = document.getElementById('view-nome');
  const viewDataNasc = document.getElementById('view-dataNasc');
  const viewEmail = document.getElementById('view-email');

  const inputNome = document.getElementById('user-nome');
  const inputDataNasc = document.getElementById('user-dataNasc');
  const inputEmail = document.getElementById('user-email');
  const inputSenha = document.getElementById('user-senha');

  const btnEditar = document.getElementById('btn-editar');
  const btnCancelar = document.getElementById('btn-cancelar');
  const toggleSenha = document.getElementById('toggleSenha');

  function carregarDados(user) {
    // Atualiza a visualização
    viewNome.textContent = user.nome || "";
    viewDataNasc.textContent = user.dataNasc ? new Date(user.dataNasc).toLocaleDateString('pt-BR') : "";
    viewEmail.textContent = user.email || "";

    inputNome.value = user.nome || "";
    inputDataNasc.value = user.dataNasc || "";
    inputEmail.value = user.email || "";
    inputSenha.value = user.senha || "";
  }

  carregarDados(userData);

  btnEditar.onclick = () => {
    profileView.classList.add('d-none');
    profileEdit.classList.remove('d-none');
  };

  btnCancelar.onclick = () => {
    carregarDados(userData);
    profileEdit.classList.add('d-none');
    profileView.classList.remove('d-none');
  };

  profileEdit.onsubmit = e => {
    e.preventDefault();

    userData.nome = inputNome.value.trim();
    userData.dataNasc = inputDataNasc.value;
    userData.email = inputEmail.value.trim();
    userData.senha = inputSenha.value;

    localStorage.setItem('userData', JSON.stringify(userData));
    carregarDados(userData);

    profileEdit.classList.add('d-none');
    profileView.classList.remove('d-none');

    alert("Perfil atualizado com sucesso!");
  };

  toggleSenha.addEventListener('click', () => {
    const isPass = inputSenha.type === "password";
    inputSenha.type = isPass ? "text" : "password";
    toggleSenha.classList.toggle("bi-eye");
    toggleSenha.classList.toggle("bi-eye-slash");
  });
});