   // Simulando dados que viriam de uma API/backend
     const usuario = {
         nome: "João Silva",
         id: 42
     };
     // const usuario = null; // descomente para simular usuário deslogado

     const userDropdown = document.getElementById("user-dropdown");

     if (usuario) {
         userDropdown.innerHTML = `
             <div class="dropdown">
                 <button class="btn btn-success dropdown-toggle" type="button"
                         data-bs-toggle="dropdown" aria-expanded="false">
                     Olá, ${usuario.nome}
                 </button>
                 <ul class="dropdown-menu">
                     <li><a class="dropdown-item" href="/Iflix/cadastroFilme.html">Novo Filme</a></li>
                     <li><a class="dropdown-item" href="/Iflix/editarUsuario?id=${usuario.id}">Minha Conta</a></li>
                     <li><a class="dropdown-item" href="/Iflix/sair">Sair</a></li>
                 </ul>
             </div>
         `;
     } else {
         userDropdown.innerHTML = `
             <div class="dropdown">
                 <button class="btn btn-success dropdown-toggle" type="button"
                         data-bs-toggle="dropdown" aria-expanded="false">
                     OPÇÕES
                 </button>
                 <ul class="dropdown-menu">
                     <li><a class="dropdown-item" href="/Iflix/home.html">Home</a></li>
                     <li><a class="dropdown-item" href="/Iflix/sobre.html">Sobre</a></li>
                     <li><a class="dropdown-item" href="/Iflix/login.html">Login</a></li>
                 </ul>
             </div>
         `;
     }