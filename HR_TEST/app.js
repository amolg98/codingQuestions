var express = require('express');
var path = require('path');
var favicon = require('serve-favicon');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');

var index = require('./routes/index');
var eraseEvents = require('./routes/eraseEvents');
var events = require('./routes/events');
var db = require("./database.js")

var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', index);
app.use('/erase', eraseEvents);
app.use('/events', events);

class actor {
  constructor(id, login, avatar_url) {
    this.id = id,
    this.login = login,
    this.avatar_url = avatar_url
  }
}

class repo {
  constructor(id, name, url) {
    this.id = id,
    this.name = name,
    this.url = url
  }
}

class event {
  constructor(id, type, actor, repo, created_at) {
    this.id = id,
    this.type = type,
    this.actor = actor,
    this.repo = repo,
    this.created_at = created_at
  }
}

var actorList = []
var repoList = []
var eventList = []

app.post('/erase', (req, res) => {
  eventList = []
  res.status(200).json({});
});

app.get('/events', (req, res, next) => {
  console.log(req.body);
  // var sql = "select * from event"
  //   var params = []
  //   db.all(sql, params, (err, rows) => {
  //       if (err) {
  //         res.status(400).json({"error":err.message});
  //         return;
  //       }
  //       res.status(200).json({
  //           "data":rows
  //       })
  //     });

    res.status(200).json({
      "data": eventList.json()
    });
  
});

app.post('/events', (req, res, next) => {
  console.log(req.body);
  const ac = new actor(req.body.actor.id, req.body.actor.login, req.body.actor.avatar_url);
  const re = new repo(req.body.repo.id, req.body.repo.name, req.body.repo.url);
  const ev = new event(req.body.id, req.body.type, ac, re, req.body.created_at);

  actorList.add(ac);
  repoList.add(re);
  eventList.add(ev);
  // console.log("actor");
  // console.log(ac);

  // var reqBody = req.body;
  // db.run(`INSERT INTO actor (id, login, avatar_url) VALUES (?,?,?)`, [ac.id, ac.login, ac.avatar_url],
  //   function (err, result) {
  //     if (err) {
  //       console.log("actor error")
  //       res.status(400).json({ "error": err.message })
  //       return;
  //     }
  // });

  // db.run(`INSERT INTO repo (id, name, url) VALUES (?,?,?)`, [re.id, re.name, re.url],
  //   function (err, result) {
  //     if (err) {
  //       console.log("repo error")
  //       res.status(400).json({ "error": err.message })
  //       return;
  //     }
  // });

  // db.run(`INSERT INTO event (id, type, actor, repo, created_at)`, [ev.id, ev.type, ev.actor, ev.repo, ev.created_at],
  //   function (err, result) {
  //     if (err) {
  //       console.log("event error")
  //       res.status(400).json({ "error": err.message });
  //       return;
  //     }
  //     res.status(201);
  //   }
  // )

  res.status(201);
});

app.get('/events/repos/{repoID}', (req, res, next) => {
  // console.log(req);
});

app.get('/events/actors', (req, res, next) => {
  // console.log(req);
  res.send({

  })
});



// catch 404 and forward to error handler
app.use(function(req, res, next) {
  var err = new Error('Not Found');
  err.status = 404;
  next(err);
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

module.exports = app;
