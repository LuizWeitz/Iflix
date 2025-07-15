document.addEventListener("DOMContentLoaded", () => { 
	
	const userNome = localStorage.getItem("USER_NOME");
	
	if (userNome) {
	        const spanUser = document.getElementById("userNome");
	        if (spanUser) {
	            spanUser.textContent = `Olá, ${userNome}`;
	        }
	    }
	
});