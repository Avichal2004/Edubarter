console.log("Script loaded");

let currentTheme = getTheme();

document.addEventListener("DOMContentLoaded", () => {
  changeTheme();
});

function changeTheme() {
  const themeButton = document.querySelector("#theme");

  if (!themeButton) {
    console.error("Element with id 'theme' not found.");
    return;
  }

  themeButton.addEventListener("click", () => {
    const oldTheme = currentTheme;

    currentTheme = currentTheme === "dark" ? "light" : "dark";

    console.log(`Theme switched to ${currentTheme}`);
    changePageTheme(currentTheme, oldTheme);
  });

  changePageTheme(currentTheme, "");
}

function setTheme(theme) {
  localStorage.setItem("theme", theme);
}

function getTheme() {
  const theme = localStorage.getItem("theme");
  return theme ? theme : "light";
}

function changePageTheme(theme, oldTheme) {
  setTheme(theme);

  const htmlElement = document.querySelector("html");
  if (oldTheme) {
    htmlElement.classList.remove(oldTheme);
  }
  htmlElement.classList.add(theme);

  const span = document.querySelector("#theme_change_button");
  if (!span) {
    console.error("Element with id 'theme_change_button' not found.");
    return;
  }

  span.textContent = theme === "light" ? "Dark" : "Light";
}
