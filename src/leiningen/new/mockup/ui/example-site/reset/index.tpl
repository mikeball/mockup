<%{:parent "../site-public.tpl"}%>

<h1>Reset Email</h1>
<div class="block">
    <form class="form-horizontal" role="form">
        <div class="form-group">
            <label for="" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="" placeholder="Email">
            </div>
        </div>
        <div style="text-align:center;">
            <a href="/{{ path }}/reset/confirm" class="btn btn-primary" role="button">
                Request Password Reset Email
            </a>
        </div>
    </form>
</div>
