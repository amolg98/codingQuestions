var sqlite3 = require('sqlite3').verbose()
var md5 = require('md5')

const DBSOURCE = "db.sqlite"

let db = new sqlite3.Database(DBSOURCE, (err) => {
    if (err) {
      // Cannot open database
      console.error(err.message)
      throw err
    }else{
        console.log('Connected to the SQLite database.')
        db.run(`CREATE TABLE actor(
            id INTEGER PRIMARY KEY,
            login text,
            avatar_url text
        )`, 
        (err) => {
            if (err) {
                // Table already exists
            }
        });
        db.run(`CREATE TABLE repo(
            id INTEGER PRIMARY KEY,
            name text,
            url text
        )`, 
        (err) => {
            if (err) {
                // Table already exists
            }
        });

        db.run(`CREATE TABLE event (
            id INTEGER PRIMARY KEY,
            type text, 
            actor integer,
            repo integer,
            created_at datetime,
            FOREIGN KEY(actor) references actor(id),
            FOREIGN KEY(repo) references repo(id)
            )`,
        (err) => {
            if (err) {
                // Table already created
            }else{
                // Table just created, creating some rows
                var insert1 = 'INSERT INTO actor (id, login, avatar_url) VALUES (?,?,?)'
                var insert2 = 'INSERT INTO events (id, name, url) VALUES (?,?,?)'
                var insert = 'INSERT INTO event (name, email, password) VALUES (?,?,?)'
                db.run(insert, [])
                db.run(insert1, [])
                db.run(insert2, [])
            }
        });  
    }
});


module.exports = db
