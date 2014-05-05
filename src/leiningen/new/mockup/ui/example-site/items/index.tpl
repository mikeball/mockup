<%{:parent "../site.tpl"}%>

<h1 class="">{{ h1 }}</h1>

<p>*** Notice that the data from index.tpl.edn is used to generate this page!</p>

{{#items}}<div class="block">
    <h2><a href="detail">{{ name }}</a></h2>
    <div><a href="detail"><img src="{{ image}}"></a></div>
</div>{{/items}}
