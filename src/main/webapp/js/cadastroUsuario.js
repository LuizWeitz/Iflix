document.querySelector("#formCadastro").addEventListener("submit", function (e) {
  e.preventDefault();

  const nome = document.getElementById("nome").value.trim();
  const dataNascimento = document.getElementById("dataNascimento").value;
  const email = document.getElementById("email").value.trim();
  const senha = document.getElementById("senha").value;
  const imgPerfilInput = document.getElementById("imgPerfil").files[0];

  if (!imgPerfilInput) {
    alert("Por favor, selecione uma foto de perfil.");
    return;
  }

  const reader = new FileReader();

  reader.onload = function () {
    const imgBase64 = reader.result;

    const novoUsuario = {
      nome: nome,
      dataNasc: dataNascimento,
      email: email,
      senha: senha,
      imgPerfil: imgBase64
    };

    fetch("cadastroUsuario", {
      method: "POST",
      headers: {
        "Content-Type": "application/json;charset=UTF-8"
      },
      body: JSON.stringify(novoUsuario)
    })
      .then(response => {
        if (!response.ok) throw new Error("Erro ao cadastrar.");
        return response.json();
      })
      .then(data => {
        alert("Usuário cadastrado com sucesso!");

        localStorage.setItem("USER_ID", data.id);
        localStorage.setItem("USER_NOME", data.nome);

        window.location.href = "login.html";
      })
      .catch(error => {
        console.error("Erro:", error);
        alert("Erro ao cadastrar usuário.");
      });
  };

  reader.readAsDataURL(imgPerfilInput);
});
