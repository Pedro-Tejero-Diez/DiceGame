# Start mongod in the background
mongod --fork --logpath /var/log/mongodb.log

# Start mongosh
mongosh --eval "load('/docker-entrypoint-initdb.d/init-db.js')"

# Keep the script running
tail -f /dev/null
