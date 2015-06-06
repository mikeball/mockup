# Mockup

Easily create responsive and clickable wireframe prototypes. Pre-loaded with everything you need including bootstrap 3 and example elements to build out wireframes. Live browser refresh of changes on file saves. Add dynamic lists of data so you don't repeat html templates in long lists of items. Uses mustache templates so they can be used as starting point when programming begins. We also sorted out how to generate a complete static html versions of the mockup that you can host in sub-folders on your own site to share with others.


## Status

Very functional at this point in time. However, it's currently in early development so expect major changes anytime.



## Getting Started

Confirm you have Java version 1.6 or higher installed. If not, you will need to install it before proceeding.
```bash
java -version
```

Confirm you have version 2.X of Leiningen installed. If not please visit http://leiningen.org/ and install it.
```bash
lein version
```

Create your project
```bash
lein new mockup my-project-name
```

Change into the generated directory and start the mockup.
```bash
cd my-project-name
lein mockup live
```

You can now visit the live mockup at http://localhost:3000/ and edit the files in the generated mockup with your favorite editor, and the browser page automatically refreshes whenever changes are saved.

The UI directory will be pre-populated with an example sample site and common scenarious like login/register so you don't have to do this for each and every site you mockup.



## How to generate a static version of your mockup for easy publishing to a web server

First stop the "live" task if it's running and start the "serve" task. We do this because the serve task won't insert the auto-refresh javascript into the html, which we don't want in our published version.
```bash
lein mockup serve
```

In a different terminal window and at a location you wish to store the generated copy
run the following wget command to mirror the site and fix all the links and add file extentions. (*note that this does not fix action attributes in forms)
```bash
wget -m -E -k http://localhost:3000/
```

You should find your generated copy of your mockup in a directory named http://localhost:3000/.

Now simply upload the generated static pages to your webserver, Amazon S3, or however you prefer. The mockup and links should work fine even if placed in sub-folders of a website.




## How to pull referenced CDN files down for local development

Often when working you may not have good internet connection in places
such as a coffee shop. In these cases it's nice to have all page assets be local to prevent
slow page refreshes. Here's an easy way to pull them down if this is the case.
Run the following commands inside of the ui/_assets folder.

```bash

wget code.jquery.com/jquery-1.11.0.min.js
wget netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css
wget netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js
wget cdnjs.cloudflare.com/ajax/libs/holder/2.3.1/holder.min.js
mkdir fonts
cd fonts
wget netdna.bootstrapcdn.com/bootstrap/3.1.1/fonts/glyphicons-halflings-regular.eot
wget netdna.bootstrapcdn.com/bootstrap/3.1.1/fonts/glyphicons-halflings-regular.svg
wget netdna.bootstrapcdn.com/bootstrap/3.1.1/fonts/glyphicons-halflings-regular.ttf
wget netdna.bootstrapcdn.com/bootstrap/3.1.1/fonts/glyphicons-halflings-regular.woff
wget -O patrick-hand-sc-regular.woff themes.googleusercontent.com/static/fonts/patrickhandsc/v2/OYFWCgfCR-7uHIovjUZXscR6S2I7R_2PmaFugZazRjg.woff

```

You then need to update the html tags in ui/master.tpl and ui/_assets/site.css







## License

Copyright © 2014 Michael Ball

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
