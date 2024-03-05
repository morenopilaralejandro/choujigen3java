function changeLang() {
    const formLang = document.getElementById("formLang");
    formLang.submit();
}

const langSelect = document.getElementById("lang");
langSelect.addEventListener("change", changeLang, false);
