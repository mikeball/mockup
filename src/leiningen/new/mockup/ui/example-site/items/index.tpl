<%{:parent "../site.tpl"}%>

<h1 class="">{{ h1 }}</h1>

<p>*** Notice that the data from index.tpl.edn is used to generate this page!</p>


<h3>Table List</h3>
<table class="table table-condensed">
  <thead>
    <tr>
      <th>Name</th>
      <th>Image Path</th>
    </tr>
  </thead>
  <tbody>
    {{#items}}<tr>
      <td><a href="detail">{{ name }}</a></td>
      <td>{{ image }}</td>
      <td>{{ customer }}</td>
      <td>{{ total }}</td>
    </tr>{{/items}}

  </tbody>
</table>


<br/><br/>


<h3>Block/Div List</h3>

{{#items}}<div class="block">
      <a href="detail"><img src="{{ image }}"></a>
      <a href="detail">{{ name }}</a>
  </div>{{/items}}
