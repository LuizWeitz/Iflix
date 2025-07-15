document.querySelector("form").addEventListener("submit", function (e) {
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
    const novoUsuario = {
      nome,
      dataNasc: dataNascimento,
      email,
      senha,
      imgPerfil: reader.result,  
    
    };

    fetch("cadastroUsuario", {
      method: "POST",
      headers: {
        "Content-Type": "application/json;charset=UTF-8" 
      },
      body: JSON.stringify(novoUsuario)
    })
      .then(response => response.json())
      .then(data => {
        if (data.resposta === "Usuário adicionado com sucesso") {
          alert("Cadastro realizado com sucesso!");
          window.location.href = "home.html";
        } else {
          alert(data.resposta);
        }
      })
      .catch(error => {
        console.error("Erro no cadastro:", error);
        alert("Erro ao cadastrar usuário.");
      });
  };

  reader.readAsDataURL(imgPerfilInput);
});
