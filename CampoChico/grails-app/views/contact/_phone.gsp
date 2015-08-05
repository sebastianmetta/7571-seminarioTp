<div id="phone${i}" class="phone-div" <g:if test="${hidden}">style="display:none;"</g:if>>
    <g:hiddenField name='phonesList[${i}].id' value='${phone?.id}'/>
    <g:hiddenField name='phonesList[${i}].deleted' value='false'/>
	<g:hiddenField name='phonesList[${i}].new' value="${phone?.id == null?'true':'false'}"/>
    
    <g:textField name='phonesList[${i}].number' value='${phone?.number}' />
        
    <g:select name="phonesList[${i}].type"
        from="${ar.com.campochico.Phone.PhoneType.values()}"
        optionKey="key"
        optionValue="value"
        value = "${phone?.type?.key}"/>

    <span id="delete-icon${UUID.randomUUID()}" class="del-phone" >
        <img src="${resource(dir:'images', file:'icon_delete.png')}" style="vertical-align:middle;"/>
    </span>
        
</div>
