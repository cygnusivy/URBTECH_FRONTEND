var cacheName = 'urbtech+-v1.2';

self.addEventListener('install', event => {

  self.skipWaiting();

  event.waitUntil(
    caches.open(cacheName)
      .then(cache => cache.addAll([

        './index.html',
	'./login-page/index.html',
        './cadastro-page/index.html',
		
		
        './assets/fontawesome/css/all.min.css',
        './assets/css/fontawesome-all.min.css',
        './assets/css/main.css',
        './assets/css/noscript.css',
		
        './assets/js/breakpoints.min.js',
        './assets/js/browser.min.js',
        './assets/js/jquery.min.js',
        './assets/js/jquery.scrollex.min.js',
        './assets/js/jquery.scrolly.min.js',
        './assets/js/main.js',
        './assets/js/util.js',
		
        './assets/sass/base/_page.scss',
        './assets/sass/base/_reset.scss',
        './assets/sass/base/_typography.scss',
		
        './assets/sass/components/_actions.scss',
        './assets/sass/components/_box.scss',
        './assets/sass/components/_button.scss',
        './assets/sass/components/_contact-method.scss',
        './assets/sass/components/_form.scss',
        './assets/sass/components/_icon.scss',
        './assets/sass/components/_icons.scss',
        './assets/sass/components/_images.scss',
        './assets/sass/components/_list.scss',
        './assets/sass/components/_pagination.scss',
        './assets/sass/components/_row.scss',
        './assets/sass/components/_section.scss',
        './assets/sass/components/_spotlights.scss',
        './assets/sass/components/_table.scss',
        './assets/sass/components/_tiles.scss',
		
        './assets/sass/layout/_banner.scss',
        './assets/sass/layout/_contact.scss',
        './assets/sass/layout/_footer.scss',
        './assets/sass/layout/_header.scss',
        './assets/sass/layout/_main.scss',
        './assets/sass/layout/_menu.scss',
        './assets/sass/layout/_wrapper.scss',
		
        './assets/sass/libs/_breakpoints.scss',
        './assets/sass/libs/_functions.scss',
        './assets/sass/libs/_html-grid.scss',
        './assets/sass/libs/_mixins.scss',
        './assets/sass/libs/_vars.scss',
        './assets/sass/libs/_vendor.scss',
        
        './assets/sass/noscript.scss',
        './assets/sass/main.scss',
		
        './assets/img/logo.png',
        './assets/img/gg.png',
        './assets/img/faceb.png',
        './assets/img/background.png',
      ]))
  );
});

self.addEventListener('message', function (event) {
  if (event.data.action === 'skipWaiting') {
    self.skipWaiting();
  }
});

self.addEventListener('fetch', function (event) {
  //Atualizacao internet
  event.respondWith(async function () {
     try {
       return await fetch(event.request);
     } catch (err) {
       return caches.match(event.request);
     }
   }());

  //Atualizacao cache
  /*event.respondWith(
    caches.match(event.request)
      .then(function (response) {
        if (response) {
          return response;
        }
        return fetch(event.request);
      })
  );*/

});
