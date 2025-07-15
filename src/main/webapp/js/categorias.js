document.addEventListener("DOMContentLoaded", () => {

	const userNome = localStorage.getItem("USER_NOME");

	if (userNome) {
		const spanUser = document.getElementById("userNome");
		if (spanUser) {
			spanUser.textContent = `Olá, ${userNome}`;
		}
	}

	const btnPesquisar = document.getElementById("btnPesquisar");
	if (btnPesquisar) {
		btnPesquisar.addEventListener("click", () => {
			const select = document.getElementById("categoriaSelect");
			const categoria = select?.value;

			if (categoria && categoria !== "Selecione uma categoria") {

				fetch(`http://localhost:8080/Iflix/buscarFilmePorGenero?genero=${categoria}`, {
					method: "GET"
				})
					.then(response => response.json())
					.then(data => {

						if (data.length === 0) {
							const container = document.getElementById("destaques");
							container.innerHTML = '<p class="text-white text-center w-100">Nenhum filme encontrado.</p>';

						} else {

							const container = document.getElementById("destaques");
							container.innerHTML = "";

							for (let filme of data) {
								const divCard = document.createElement("div");
								divCard.className = "movie-card";

								const img = document.createElement("img");
								img.src = filme.imgCapa;
								img.alt = filme.titulo;
								img.className = "rounded w-100";

								divCard.appendChild(img);
								container.appendChild(divCard);
							}
						}
					})
					.catch(() => {
						alert("Erro ao buscar filmes");
					});

			} else {
				alert("Por favor, selecione uma categoria.");
			}
		});
	}

});
