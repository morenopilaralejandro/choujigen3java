function resetPlayerSearch() {
    const name = document.getElementById("playerName");
    const defPositi = document.getElementById("positi1");
    const defAttri = document.getElementById("attri1");
    const defGender = document.getElementById("gender1");
    const h1 = document.getElementById("hissatsu1");
    const h2 = document.getElementById("hissatsu2");
    const h3 = document.getElementById("hissatsu3");
    const h4 = document.getElementById("hissatsu4");

    name.value="";
    defPositi.checked = true;
    defAttri.checked = true;
    defGender.checked = true;
    h1.value="";
    h2.value="";
    h3.value="";
    h4.value="";
}

function submitPlayerSearch() {
    const form = document.getElementById("formPlayerSearch");
    form.submit();
}

function nextPage() {
    const currentPage = document.getElementById("currentPage");
    currentPage.value++;
    submitPlayerSearch();
}

function prevPage() {
    const currentPage = document.getElementById("currentPage");
    currentPage.value--;
    submitPlayerSearch();
}

function changePage(page) {
    const currentPage = document.getElementById("currentPage");
    currentPage.value=page;
    submitPlayerSearch();
}

function newSearch(page) {
    const currentPage = document.getElementById("currentPage");
    currentPage.value=0;
    submitPlayerSearch();
}

const submitButton = document.getElementById("submitButton");
submitButton.addEventListener("click", newSearch, false);

const resetButton = document.getElementById("resetButton");
resetButton.addEventListener("click", resetPlayerSearch, false);
