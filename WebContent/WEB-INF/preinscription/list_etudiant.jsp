<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <section class="tables">   
            <div class="container-fluid">
              <div class="row">
                <div class="col-lg-12">
                  <div class="card">
                    <div class="card-close">
                      <div class="dropdown">
                        <button type="button" id="closeCard1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="dropdown-toggle">
                          <i class="fa fa-ellipsis-v"></i>
                        </button>
                        <div aria-labelledby="closeCard1" class="dropdown-menu dropdown-menu-right has-shadow">
                          <a href="#" class="dropdown-item remove"><i class="fa fa-times"></i>Close</a>
                          <a href="#" class="dropdown-item edit"><i class="fa fa-gear"></i>Edit</a>
                        </div>
                      </div>
                    </div>
                    <div class="card-header d-flex align-items-center">
                      <h3 class="h4">Liste des étudiants</h3>
                      <form method="post" action="#">
                          <input type="submit" class="btn btn-warning" value="PDF" />
                      </form>
                    </div>
                    <table class="table">
                      <thead>
                        <tr>
                          <th></th>
                          <th>Nom</th>
                          <th>Prénom</th>
                          <th>Niveau</th>
                          <th></th>
                          <th></th>
                          <th></th>
                          <th></th>
                          <th></th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach var="etudiants" items="${etudiants}">
                          <tr>
                              <td>
                                <input type="hidden" name="${etudiants.id_parcours}">
                              </td>
                              <td>${etudiants.nom}</td>
                              <td>${etudiants.prenom}</td>
                              <td>${etudiants.niveau}</td>
                              <td>
                                 <form method="post" action="cursus">
                                    <input type="hidden" name="cursus" value="${etudiants.id_etudiant}">
                                    <!-- <input type="submit" class="btn btn-danger" value="Cursus" /> -->
                                    <!-- <button type="button" class="btn btn-primary modaly" data-toggle="modal" data-target="" id="">Cursus</button> -->
                                    <!-- <a href="list_etudiant?id=${etudiants.id_etudiant}"> -->
                                    <!-- <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#modifierEtudiant_${etudiant.id_record}"> Cursus</button> -->
                                    <button type="button" class="btn btn-primary modaly" data-toggle="modal" data-target="#cursus_${etudiants.id_etudiant}" id="modaly_${critere.id_critere}">
                                      Cursus
                                    </button>
                                </form>
                              </td>
                              <td>
                                 <form method="post" action="#">
                                    <input type="submit" class="btn btn-success" value="Carte d'étudiant" />
                                </form>
                              </td>
                              <td>
                                 <form method="post" action="#">
                                    <input type="submit" class="btn btn-info" value="Certificat de Scolarité" />
                                </form>
                              </td>
                              <td>
                                 <form method="post" action="#">
                                    <input type="submit" class="btn btn-warning" value="Relevé de notes" />
                                </form>
                              </td>
                             
                          </tr>
                      </c:forEach>
                      </tbody>                        
                   </table>
                </div>
            </div>
        </div>
    </div>
</section>
 
<c:forEach var="etudiants" items="${etudiants}">


<div class="modal fade" id="cursus_${etudiants.id_etudiant}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" style="width:100%;height:100%;">
      <div class="modal-dialog" role="document" >
          <div class="modal-content">
              <div class="modal-header">
                  <h3 class="modal-title" id="exampleModalLabel">Modification critère</h3>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                  </button>
                  <div class="row">
                    <div class="reponse" style="float:right;background-color:#67C0F1;" id="response_${etudiants.id_etudiant}">
            
                    </div>
                  </div>
          
              </div>

              <div class="modal-body">
                  <div class="row">
                      <div class="col-md-12">
                          <div class="box box-danger">
                              <div class="box-header">
                                  <h3 class="box-title" id=""></h3>
                              </div>
                              <div class="box-body">
                                   <c:forEach var="cursus" items="${cursus}">
                                      <c:if test="${etudiants.id_etudiant == ${cursus.id_etudiant}}">
                                          <!-- <p> ${cursus.nom} </p> -->
                                          <c:out value="${cursus.id_etudiant}">OKKKK</c:out>
                                          <!-- <p>OK</p> -->
                                      </c:if>
                                   </c:forEach>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>
        
  
              <div class="modal-footer">
                  <button type="submit" class="btn btn-primary">Enregistrer</button>
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
         
              </div>
          </div>
      </div>
</div>

</c:forEach>
