function changeLang() {
    const langForm = document.getElementById("langForm");
    langForm.submit();
}

const langSelect = document.getElementById("lang");
langSelect.addEventListener("change", changeLang, false);
