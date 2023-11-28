var user = "user";
var password = "password";

// Connect to the admin database to create the user
db = db.getSiblingDB('admin');

// Check if the user already exists
var user = db.getUsers({ user: "user" });

if (!user.length) {
  // User doesn't exist, create it
  db.createUser({
    user: "user",
    pwd: "password",
    roles: [
      { role: "readWrite", db: "Dice_Game" },

    ],
  });