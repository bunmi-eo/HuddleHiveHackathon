const bucketList = [
    "Try a new restaurant together",
    "Have a picnic in the park",
    "Go on a spontaneous road trip",
    "Have a themed movie marathon",
    "Try an escape room challenge",
    "Visit an amusement park or arcade",
    "Take a workout or dance class together",
    "Do a thrift store outfit challenge",
    "Have a DIY spa day at home",
    "Bake or cook a new recipe together",
    "Try a food challenge (spicy, blind taste test, etc.)",
    "Go to a concert or live music event",
    "Visit a museum or art gallery",
    "Go hiking or on a nature walk",
    "Take a pottery or painting class",
    "Have a board game or video game night",
    "Do a photo shoot day",
    "Go bowling or mini-golfing",
    "Try a new coffee shop",
    "Go to a comedy show or open mic night",
    "Take a random train/bus and explore a new place",
    "Plan a staycation or sleepover",
    "Volunteer together for a good cause",
    "Make friendship bracelets or matching DIY crafts",
    "Go on a bookstore or library date",
    "Write each other heartfelt letters",
    "Sing your hearts out at karaoke",
    "Make a time capsule to open in the future",
    "Try a new sport or outdoor activity",
    "Go stargazing with blankets and snacks",
    "Visit a farmers’ market and buy each other a small gift",
    "Create a playlist for each other",
    "Try an all-you-can-eat buffet or food festival",
    "Go camping or have a bonfire night",
    "Plan a dream trip together",
    "Take a yoga or meditation class",
    "Visit a drive-in movie theater",
    "Have a zero-budget day",
    "Write a short story together",
    "Plan and execute a random act of kindness",
    "Dress up fancy and go somewhere casual",
    "Visit a zoo or aquarium",
    "Take a personality or friendship quiz together",
    "Create a scrapbook of your best memories",
    "Have a 'no phones' hangout day",
    "Go to a new city and explore without a plan",
    "Make a funny TikTok or Instagram Reel together",
    "Have a self-care day",
    "Plan a secret surprise for each other",
    "Recreate your first-ever friend date"
];

const listContainer = document.getElementById("bucket-list");

// Load checklist from local storage
const savedChecklist = JSON.parse(localStorage.getItem("friendDateChecklist")) || {};

bucketList.forEach((item, index) => {
    const listItem = document.createElement("li");
    const checkbox = document.createElement("input");

    checkbox.type = "checkbox";
    checkbox.checked = savedChecklist[index] || false;

    checkbox.addEventListener("change", () => {
        savedChecklist[index] = checkbox.checked;
        localStorage.setItem("friendDateChecklist", JSON.stringify(savedChecklist));
    });

    listItem.appendChild(checkbox);
    listItem.appendChild(document.createTextNode(` ${item}`));
    listContainer.appendChild(listItem);
});

// Reset button to clear checklist
document.getElementById("reset").addEventListener("click", () => {
    localStorage.removeItem("friendDateChecklist");
    document.querySelectorAll("input[type='checkbox']").forEach(checkbox => checkbox.checked = false);
});
