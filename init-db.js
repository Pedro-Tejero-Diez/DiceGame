use Dice_Game

db.createUser({
    user: "normalUser",
    pwd: "password",
    roles: [
      { role: "readWrite", db: "Dice_Game" }
    ]
  })