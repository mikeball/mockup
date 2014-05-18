# Mockup

Easily create clickable wireframe prototypes. Pre-loaded with everything you need including bootstrap 3 responsive, and mockup example elements. Live refresh of changes in the browser when you save changes. Handles dynamic lists of data so you don't repeat html templates in long lists of items. Uses mustache templates so they can be used as starting point when programming begins. We sorted out how to generate a complete static html versions of the mockup that you can host in sub-folders on your own site or Amazon S3 bucket.


## Status

Very functional at this point in time. However, it's currently in early development so expect major changes anytime. 



## Getting Started

1. Confirm you have Java version 1.6 or higher installed. If not, you will need to install it before proceeding.
```bash
java -version
```

2. Confirm you have version 2.X of Leiningen installed. If not please visit http://leiningen.org/ and install it.
```bash
lein version
```

3. Create your project
```bash
lein new mockup my-project-name
```

4. Change into the generated directory and start the mockup.
```bash
cd my-project-name
lein mockup run
```

You can now visit the live mockup at http://localhost:3000/ and edit the files in the generated mockup with your favorite editor, and the browser page automatically refreshes whenever changes are saved.  

The UI directory should be pre-populated with an example sample site and common scenarious like login/register so you don't have to do this for each and every site you mockup.

Please see the generated README.md and examples within your generated mockup for additional usages.





## License

Copyright © 2014 Michael Ball

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
