<%{:parent "../site.tpl"}%>

<style>
  .block {margin-bottom:30px;}
</style>

<h1>Common Design Elements for Quick Reference</h1>

<h2>Common Layouts</h2>

<div class="row">
    <div class="col-md-6">
        <div class="block">
            <h3>Left Side of a Grid</h3>
        </div>
    </div>
    <div class="col-md-6">
        <div class="block">
            <h3>Right Side of a Grid</h3>
        </div>
    </div>
</div>

<h2>Common Design Elements</h2>
<div class="block">
    <h3>*** a block with dashed borders ***</h3>
</div>


<div class="block">
    <h3>Buttons</h3>
    <a href="" class="btn btn-primary" role="button">A Primary Button</a>
    <a href="" class="btn btn-default" role="button">A Default Button</a>
</div>


<div class="block">
    <h3>Placeholder Images</h3>
    <img src="holder.js/200x160/text:My Image Text Here">
    <img src="holder.js/400x160/text:My Wide Image Text Here">
</div>



<div class="block">
    <h3>A Basic Form</h3>
    <form class="form-horizontal" role="form">
        <div class="form-group">
            <label for="" class="col-sm-2 control-label">Name</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="" placeholder="Name">
            </div>
        </div>

        <div class="form-group">
            <label for="" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="" placeholder="Email">
            </div>
        </div>

        <div class="form-group">
            <label for="" class="col-sm-2 control-label">State</label>
            <div class="col-sm-10">
                <select class="form-control">
                    <option value=""></option>
                    <option value="">Arizona</option>
                    <option value="">Oregon</option>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label for="" class="col-sm-2 control-label"></label>
            <div class="col-sm-10">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="">
                        this is some option with a checkbox
                    </label>
                </div>
            </div>
        </div>



        <div class="form-group" style="font-size:24px;text-align:center;">
            *** Additional new account fields, etc...
        </div>

        <hr/>
        <div style="text-align:center;">
            <a class="btn btn-primary" href="" role="button">
                Do Something and Continue >>
        </a></div>
    </form>
</div>

<div class="block">
    <h3>Select List</h3>
    <form class="form-inline" role="form">
        <select class="form-control">
          <option>Select Option 1</option>
          <option>Select Option 2</option>
          <option>Select Option 3</option>
        </select>
        <a class="btn btn-primary" href="" role="button">
                GO >>
        </a>
    </form>
</div>

<div class="block">
    <h3>Check Boxes</h3>
    <div class="checkbox">
      <label>
        <input type="checkbox" value="">
        this is some option with a checkbox
      </label>
    </div>
</div>



<div class="block">
    <h3>Search Box</h3>
    <form class="" role="search"
        action="">
        <div class="input-group">
            <input type="text" class="form-control" style="width:260px;" placeholder="Search" name="q" id="srch-term">
            <div class="input-group-btn" style="width:auto;">
                <a href="" class="btn btn-default" role="button">
                    <span class="glyphicon glyphicon-search"></span>
                </a>
            </div>
        </div>
    </form>
</div>

<div class="block">
    <h3>File Upload</h3>
    <form class="form-horizontal" role="form">
        <div class="input-group" style="margin:20px;">
            <span class="input-group-btn">
                <span class="btn btn-primary btn-file">
                    Browse&hellip; <input type="file" multiple>
                </span>
            </span>
            <input type="text" class="form-control" readonly>
        </div>
        <div style="text-align:center;">
            <a class="btn btn-default" href="" role="button">
                Upload and Continue >>
        </a></div>
    </form>
</div>

<div class="block">
    <h3><a href="email" target="_blank">Example Email Layout</a></h3>
</div>


<div class="block">
    <h3>Notes</h3>
    <div class="notes">
      My notes here...
    </div>
</div>



<div class="block">
    <h3>Action Bar</h3>

    <div class="actions">
      <a href="" class="btn btn-default btn-lg" role="button">Cancel</a>
      <a href="" class="btn btn-primary btn-lg" role="button">Complete Some Action!</a>
    </div>

</div>




<div class="block role-section myrole1">
  <div class="role-section-header myrole1">Notes about the role...</div>
  <h3>My Role #1 Specific Section</h3>
</div>


<div class="block role-section myrole2">
  <div class="role-section-header myrole2">Notes about the role...</div>
  <h3>My Role #2 Specific Section</h3>
</div>
