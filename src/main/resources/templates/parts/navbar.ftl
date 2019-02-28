<#include "security.ftl">
<#import "login_form.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">SA</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-link">
                <a class="nav-link" href="/main">Main</a>
            </li>

            <#if isAdmin>
                <li class="nav-link">
                    <a class="nav-link" href="/users">UserList</a>
                </li>
            </#if>

        </ul>

        <div class="navbar-text mr-3">${name}</div>
        <@l.logout/>
    </div>
</nav>