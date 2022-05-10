<#macro navheadbar userIsLog id>
<header>
    <nav class="navbar">
    	<ul>
	    <#if (userIsLog)!false>
    	    <li>
    	    	<a href="/professeurs/${id}"> Accueil </a>
    	    </li>
	    </#if>
            <li>
		<#if (userIsLog)!false>
            	     <a href="/logout"> Déconnexion </a>
		<#else>
		     <a href="/login"> Connexion </a>
		</#if>
            </li>
            <li>
		<a href="/eleves"> Liste des élèves </a>
            </li>
	    <li>
		<a href="/gommettes"> Liste des gommettes </a>
            </li>
        </ul>
    </nav>
</header>
</#macro>