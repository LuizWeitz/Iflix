document.addEventListener("DOMContentLoaded", () => {

	document.getElementById("enviar").addEventListener("click", (e) => {
		e.preventDefault(e);

		const email = document.getElementById('email').value;
		const senha = document.getElementById('senha').value;

		fetch(`http://localhost:8080/Iflix/login?email=${email}&senha=${senha}`, {
			method: "POST",
		})
			.then((response) => response.json())
			.then((data) => {
				localStorage.setItem("USER_ID", data.user_id);
				localStorage.setItem("USER_NOME", data.user_nome);
				
				window.location.href = "home.html";
			})
			.catch(() => {
				alert("Erro ao autenticar");
			});
	});
});


