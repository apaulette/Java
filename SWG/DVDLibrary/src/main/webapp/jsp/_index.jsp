<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>DVD Library :: Home</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/custom/styles.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon-dvd.png">
    </head>
    <body>
        <!-- Static navbar -->
        <nav class="navbar navbar-inverse navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <span class="new-navbar-brand">DVD Library</span>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#" id="toggleSidebar"><span class="glyphicon glyphicon-plus"></span><span class="sr-only">Add</span></a>
                        </li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>
        <div class="container-fluid">
            <div class="row">
                <div class="col-xs-12" id="shelvesDiv"></div>
                <div class="col-xs-3 collapse" id="sidebar">
                    <div class="row">
                        <div class="col-xs-10 col-xs-offset-1">
                            <h3>Add New DVD</h3>
                            <div id="validationErrors" class="warning bg-danger"></div>
                            <form class="form-vertical" role="form">
                                <div class="form-group">
                                    <label for="add-title">Title</label><br>
                                    <input type="text" class="form-control" id="add-title" placeholder="DVD Title" />
                                </div>
                                <div class="form-group">
                                    <label for="add-ratingUS">MPAA Rating</label><br>
                                    <select class="form-control" id="add-ratingUS">
                                        <option value="" selected="selected">Select an MPAA rating:</option>
                                        <option value="G">G</option>
                                        <option value="PG">PG</option>
                                        <option value="PG-13">PG-13</option>
                                        <option value="R">R</option>
                                        <option value="NC-17">NC-17</option>
                                        <option value="Unrated">Unrated</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="add-releaseDate">Release Year</label><br>
                                    <input type="text" class="form-control" id="add-releaseDate" placeholder="Release Year" />
                                </div>
                                <div class="form-group">
                                    <label for="add-directorName">Director Name</label><br>
                                    <input type="text" class="form-control" id="add-directorName" placeholder="Director Name" />
                                </div>
                                <div class="form-group">
                                    <label for="add-studioName">Studio Name</label><br>
                                    <input type="text" class="form-control" id="add-studioName" placeholder="Studio Name" />
                                </div>
                                <div class="form-group">
                                    <label for="add-userRating">User Rating</label><br>
                                    <select class="form-control" id="add-userRating">
                                        <option value="" selected="selected">Select your rating of this DVD:</option>
                                        <option value="5">&#9733;&#9733;&#9733;&#9733;&#9733;</option>
                                        <option value="4">&#9733;&#9733;&#9733;&#9733;</option>
                                        <option value="3">&#9733;&#9733;&#9733;</option>
                                        <option value="2">&#9733;&#9733;</option>
                                        <option value="1">&#9733;</option>
                                        <option value="0">NO STARS - Why do you even own this?</option>
                                    </select>
                                </div>                              
                                <div class="form-group">
                                    <label for="add-userComment">User Comment</label><br>
                                    <textarea rows="3" class="form-control" id="add-userComment" placeholder="User Comments" ></textarea>
                                </div>                                
                                <div class="form-group">
                                    <label for="add-coverArt">Cover Art</label><br>
                                    <input type="text" class="form-control" id="add-coverArt" placeholder="Ex.: movie-title.jpg" />
                                </div>
                                <div class="form-group">
                                    <button type="submit" id="add-button" class="btn btn-default">Add DVD Entry</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <!-- OUR FRIENDS THE MODALS BEGIN HERE -->
            <div class="modal fade" id="detailsModal" tabindex="-1" role="dialog"
                 aria-labelledby="detailsModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-xl">
                    <div class="modal-content">
                        <div class="modal-body">
                            <h3 class="modal-title" id="entry-title"></h3>
                            <table class="table" id="modalDetailsTable">
                                <tr>
                                    <td rowspan="6" id="entry-coverArt"></td>
                                    <th>MPAA Rating</th>
                                    <td id="entry-ratingUS"></td>
                                </tr>
                                <tr>
                                    <th>Release Year</th>
                                    <td id="entry-releaseDate"></td>
                                </tr>
                                <tr>
                                    <th>Director</th>
                                    <td id="entry-directorName"></td>
                                </tr>
                                <tr>
                                    <th>Studio</th>
                                    <td id="entry-studioName"></td>
                                </tr>
                                <tr>
                                    <th>User Rating</th>
                                    <td id="entry-userRating"></td>
                                </tr>
                                <tr>
                                    <th>User Comments</th>
                                    <td id="entry-userComment"></td>
                                </tr>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <!--<button id="editThis"></button>--> 
                            <button type="button" class="btn btn-default" data-entry-id="" data-name="" data-toggle="modal" data-dismiss="modal" data-target="#editModal">Edit or Delete</button>                            
                            <button type="button" class="btn btn-default modalClose" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal fade" id="editModal" tabindex="-1" role="dialog"
                 aria-labelledby="editDetailsModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-xl">
                    <div class="modal-content">
                        <div class="modal-body">
                            <h3 class="modal-title"></h3>
                            <form class="form-horizontal" role="form">
                                <div class="form-group">
                                    <label for="edit-entry-title" 
                                           class="col-md-4 control-label">Title</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-entry-title" placeholder="Title" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-entry-ratingUS" 
                                           class="col-md-4 control-label">MPAA Rating</label>
                                    <div class="col-md-8">
                                    <select class="form-control" id="edit-entry-ratingUS">
                                        <option value="" selected="selected">Select an MPAA rating:</option>
                                        <option value="G">G</option>
                                        <option value="PG">PG</option>
                                        <option value="PG-13">PG-13</option>
                                        <option value="R">R</option>
                                        <option value="NC-17">NC-17</option>
                                        <option value="Unrated">Unrated</option>
                                    </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-entry-releaseDate" 
                                           class="col-md-4 control-label">ReleaseYear</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-entry-releaseDate" placeholder="Release Year" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-entry-directorName" 
                                           class="col-md-4 control-label">Director</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-entry-directorName" placeholder="Director Name" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-entry-studioName" 
                                           class="col-md-4 control-label">Studio</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-entry-studioName" placeholder="Studio Name" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-entry-userRating" 
                                           class="col-md-4 control-label">User Rating</label>
                                    <div class="col-md-8">
                                    <select class="form-control" id="edit-entry-userRating">
                                        <option value="" selected="selected">Select your rating of this DVD:</option>
                                        <option value="5">&#9733;&#9733;&#9733;&#9733;&#9733;</option>
                                        <option value="4">&#9733;&#9733;&#9733;&#9733;</option>
                                        <option value="3">&#9733;&#9733;&#9733;</option>
                                        <option value="2">&#9733;&#9733;</option>
                                        <option value="1">&#9733;</option>
                                        <option value="0">NO STARS - Why do you even own this?</option>
                                    </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-entry-userComment" 
                                           class="col-md-4 control-label">User Comment</label>
                                    <div class="col-md-8">
                                        <textarea rows="3" class="form-control" id="edit-entry-userComment" placeholder="User Comments" ></textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit-entry-coverArt" class="col-md-4 control-label">Cover Art</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" id="edit-entry-coverArt" placeholder="Ex. movie-name.jpg" />
                                    </div>
                                </div>                                
                                <div class="form-group">
                                    <div class="col-md-offset-4 col-md-8">
                                        <button type="submit" id="edit-button" class="btn btn-default" data-dismiss="modal">Edit Entry</button>
                                        <button type="submit" id="delete-button" class="btn btn-default" data-dismiss="modal">Delete Entry</button>
                                        <button type="button" class="btn btn-default modalClose" data-dismiss="modal">Cancel</button>
                                        <input type="hidden" id="edit-entry-id" />
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/custom/dvdLibrary.js"></script>

    </body>
</html>

