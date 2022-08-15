<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
    <div>
        <a type="button" class="btn btn-primary btn-md" href="/add-todo">Add Todo</a>
    </div>
    <br>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3>List of TODO's</h3>
        </div>
        <div class="panel-body">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th width="30%">Description</th>
                    <th width="20%">Date</th>
                    <th width="15%">Finished</th>
                    <th width="40%"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${todos}" var="todo">
                        <td>${todo.description}</td>
                        <td><fmt:formatDate value="${todo.date}"
                                            pattern="dd/MM/yyyy" /></td>
                        <td> ${todo.isDone} </td>
                        <td><a type="button" class="btn btn-success"
                               href="/update-todo?id=${todo.id}">Update</a>
                            <a type="button" class="btn btn-warning"
                               href="/delete-todo?id=${todo.id}">Delete</a>
                            <a type="checkbox" class="btn btn-info"
                               href="/finish-todo?id=${todo.id}">Change Status</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>