# Getting Started

1. Confirm you have Java installed
```bash
java -version
```
..* If you don't please install.


2. Confirm you have recent version of Leiningen installed.
```bash
lein help
```
..* If you don't please visit http://leiningen.org/ and install it.


3. Create your project
```bash
lein new tao-mockup my-project

lein new mockup my-project


```

4. Run and Build your Mockup
```bash
lein tao run-mockup

lein mockup run


```
You can visit the live mockup at http://localhost:3000/ and edit the mockup with your favorite editor.
Notice how the browser page automatically refreshes whenever changes are saved.

The UI directory which has been pre-populated with sample site and common elements
for an easy starting point.



5. Generate a Static version of your Mockup for easy publishing to a web server or S3

First stop the ???? task if it's running and start the serve task. The serve task won't insert the auto-refresh 
javascript into the html, which we don't want in the published version.

```bash
lein tao serve-mockup

lein mockup serve

```

Now, in a different terminal window and at a location you wish to store the generated copy
run the following command to mirror the site and fix all the links and file extentions.


```bash
wget -m -E -k http://localhost:3000/
```

You should find your generated mockup in a directory named http://localhost:3000/.

Now simply upload to your webserver or S3 however you prefer. The mockup and links 
should work fine even if placed in sub-folders on your site.






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



