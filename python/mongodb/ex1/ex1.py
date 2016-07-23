#!/usr/bin/python3

import bottle
import pymongo
import guestbookDOA

@bottle.route('/')
def guestbook_index():
    mynames_list = guestbook.find_names()
    return bottle.template( 'index', dict(mynames = mynames_list))
    

@bottle.route('/newguest', method='POST')
def insert_newguest():
    name = bottle.request.forms.get("name")
    email = bottle.request.forms.get("email")
    guestbook.insert_name(name,email)
    bottle.redirect('/')

@bottle.route('/hello')
def hello():
    return "Hello World"

if __name__=="__main__":
    print("entering")
    connection_string = "mongodb://localhost"

    #Open connection
    client = pymongo.MongoClient(connection_string)

    #Now set a context
    db = client.names
    
    guestbook = guestbookDOA.GuestbookDAO(db)

    bottle.run(host = 'localhost', port = 8082, debug = True) 
    
    print("leaving")
